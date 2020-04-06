package com.luv2code.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author RAY-ABEL
 *
 */

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String YoutubeChannel;
	
	@Column(name="hobby")
	private String Hobby;
	
	@OneToOne(mappedBy ="instructorDetail",
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,
					CascadeType.REFRESH})
	private Instructor instructor;
	
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public InstructorDetail() {
		
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		YoutubeChannel = youtubeChannel;
		Hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return YoutubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		YoutubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return Hobby;
	}

	public void setHobby(String hobby) {
		Hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", YoutubeChannel=" + YoutubeChannel + ", Hobby=" + Hobby + "]";
	}
	
	

}
