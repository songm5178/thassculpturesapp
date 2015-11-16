package edu.rosehulman.thassculptures;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.appspot.thassculptures.sculptures.Sculptures;
import com.appspot.thassculptures.sculptures.model.Artist;
import com.appspot.thassculptures.sculptures.model.ArtistCollection;
import com.appspot.thassculptures.sculptures.model.SculptureCollection;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

public class ArtistPageActivity extends Activity {

	private Sculptures mService;
	private String artistName;
	private String artistLastName;
    private TextView artistDescription;
    private ImageView artistImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_artist_page);

		Sculptures.Builder builder = new Sculptures.Builder(AndroidHttp.newCompatibleTransport(),
				new GsonFactory(), null);
		mService = builder.build();

		Intent intent = getIntent();
		String artistFullName = intent.getStringExtra(SculptureActivity.ARTIST_NAME);
		String[] artistFullNameArray = artistFullName.split(" ");
		artistName = artistFullNameArray[0];
		artistLastName = artistFullNameArray[artistFullNameArray.length - 1];

		artistImage = (ImageView) findViewById(R.id.imageView_artist);
		TextView artistNameText = (TextView) findViewById(R.id.textView_artist_name);
		artistDescription= (TextView) findViewById(R.id.textView_artist_description);

		artistNameText.setText(artistFullName);
        update();
    }



    private void update() {
        //
        new QueryForArtistTask().execute();

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.artist_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	class QueryForArtistTask extends AsyncTask<Void, Void, ArtistCollection> {

		@Override
		protected ArtistCollection doInBackground(Void... params) {
			ArtistCollection artists = null;

			try{
				Sculptures.Artist.List query = mService.artist().list();
				query.setLimit(100L);
				artists = query.execute();
			} catch (IOException e) {
				Log.e("MIN", "Failed Loading artist " + e);
			}
			return artists;
		}

		@Override
		protected void onPostExecute(ArtistCollection artistCollection) {
			super.onPostExecute(artistCollection);

			if(artistCollection == null){
				Log.d("MIN", "Failed loading artists, result is null");
				return;
			}

            for(Artist a: artistCollection.getItems()){
                if(a.getFname().equals(artistName) && a.getLname().equals(artistLastName)){
                    artistDescription.setText(a.getDescription());
                    new DownloadImageTask().execute(a.getImage());
                    return;
                }
            }

		}
	}
    class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        private String mUrl;

        @Override
        protected Bitmap doInBackground(String... params) {
            //
            Bitmap bitmap = null;
            mUrl = params[0];
            try {
                InputStream in = new java.net.URL(mUrl).openStream();
                //
                bitmap = BitmapFactory.decodeStream(in);

            } catch (MalformedURLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Auto-generated method stub
            artistImage.setImageBitmap(result);
        }

    }
}
