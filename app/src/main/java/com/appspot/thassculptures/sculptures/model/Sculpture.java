/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-08-03 17:34:38 UTC)
 * on 2015-10-28 at 14:26:35 UTC 
 * Modify at your own risk.
 */

package com.appspot.thassculptures.sculptures.model;

/**
 * Model definition for Sculpture.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the sculptures. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Sculpture extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String artist;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("artist_key")
  private String artistKey;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String audio;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String description;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("do")
  private String do__;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String entityKey;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String image;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String location;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String think;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String title;

  /**
   * @return value or {@code null} for none
   */
  public String getArtist() {
    return artist;
  }

  /**
   * @param artist artist or {@code null} for none
   */
  public Sculpture setArtist(String artist) {
    this.artist = artist;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public String getArtistKey() {
    return artistKey;
  }

  /**
   * @param artistKey artistKey or {@code null} for none
   */
  public Sculpture setArtistKey(String artistKey) {
    this.artistKey = artistKey;
    return this;
  }

  /**
   * @see #decodeAudio()
   * @return value or {@code null} for none
   */
  public String getAudio() {
    return audio;
  }

  /**

   * @see #getAudio()
   * @return Base64 decoded value or {@code null} for none
   *
   * @since 1.14
   */
  public byte[] decodeAudio() {
    return com.google.api.client.util.Base64.decodeBase64(audio);
  }

  /**
   * @see #encodeAudio()
   * @param audio audio or {@code null} for none
   */
  public Sculpture setAudio(String audio) {
    this.audio = audio;
    return this;
  }

  /**

   * @see #setAudio()
   *
   * <p>
   * The value is encoded Base64 or {@code null} for none.
   * </p>
   *
   * @since 1.14
   */
  public Sculpture encodeAudio(byte[] audio) {
    this.audio = com.google.api.client.util.Base64.encodeBase64URLSafeString(audio);
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description description or {@code null} for none
   */
  public Sculpture setDescription(String description) {
    this.description = description;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public String getDo() {
    return do__;
  }

  /**
   * @param do__ do__ or {@code null} for none
   */
  public Sculpture setDo(String do__) {
    this.do__ = do__;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public String getEntityKey() {
    return entityKey;
  }

  /**
   * @param entityKey entityKey or {@code null} for none
   */
  public Sculpture setEntityKey(String entityKey) {
    this.entityKey = entityKey;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public String getImage() {
    return image;
  }

  /**
   * @param image image or {@code null} for none
   */
  public Sculpture setImage(String image) {
    this.image = image;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public String getLocation() {
    return location;
  }

  /**
   * @param location location or {@code null} for none
   */
  public Sculpture setLocation(String location) {
    this.location = location;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public String getThink() {
    return think;
  }

  /**
   * @param think think or {@code null} for none
   */
  public Sculpture setThink(String think) {
    this.think = think;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title title or {@code null} for none
   */
  public Sculpture setTitle(String title) {
    this.title = title;
    return this;
  }

  @Override
  public Sculpture set(String fieldName, Object value) {
    return (Sculpture) super.set(fieldName, value);
  }

  @Override
  public Sculpture clone() {
    return (Sculpture) super.clone();
  }

}