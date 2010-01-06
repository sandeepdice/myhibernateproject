package com.oreilly.hh;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *       Represents a single playable track in the music database.
 *       @author Jim Elliott (with help from Hibernate)
 *     
*/
public class Track implements Serializable {

    /** identifier field */
    private Integer id;

    /** persistent field */
    private String title;

    /** persistent field */
    private String filePath;

    /** nullable persistent field */
    private Date playTime;

    /** nullable persistent field */
    private Date added;

    /** persistent field */
    private short volume;

    /** full constructor */
    public Track(String title, String filePath, Date playTime, Date added, short volume) {
        this.title = title;
        this.filePath = filePath;
        this.playTime = playTime;
        this.added = added;
        this.volume = volume;
    }

    /** default constructor */
    public Track() {
    }

    /** minimal constructor */
    public Track(String title, String filePath, short volume) {
        this.title = title;
        this.filePath = filePath;
        this.volume = volume;
    }

    public Integer getId() {
        return this.id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /** 
     * Playing time
     */
    public Date getPlayTime() {
        return this.playTime;
    }

    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }

    /** 
     * When the track was created
     */
    public Date getAdded() {
        return this.added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    /** 
     * How loud to play the track
     */
    public short getVolume() {
        return this.volume;
    }

    public void setVolume(short volume) {
        this.volume = volume;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
