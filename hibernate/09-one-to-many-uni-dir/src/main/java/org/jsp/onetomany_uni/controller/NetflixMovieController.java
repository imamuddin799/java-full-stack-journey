package org.jsp.onetomany_uni.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsp.onetomany_uni.dao.NetflixMovieDao;
import org.jsp.onetomany_uni.dto.Movie;
import org.jsp.onetomany_uni.dto.Netflix;

public class NetflixMovieController {

	public static void main(String[] args) {
		
		Movie movie1 = new Movie();
		movie1.setId(1001);
		movie1.setName("salaar");
		movie1.setRating(8.0);
		
		Movie movie2 = new Movie();
		movie2.setId(1002);
		movie2.setName("devara");
		movie2.setRating(8.0);
		
		Movie movie3 = new Movie();
		movie3.setId(1003);
		movie3.setName("Jolly LLb");
		movie3.setRating(3.0);
		
		Movie movie4 = new Movie();
		movie4.setId(1004);
		movie4.setName("Hero");
		movie4.setRating(9.0);
		
		Movie movie5 = new Movie();
		movie5.setId(1005);
		movie5.setName("Dosti");
		movie5.setRating(7.0);
		
		Movie movie6 = new Movie();
		movie6.setId(1006);
		movie6.setName("Saudagar");
		movie6.setRating(9.0);
		
		List<Movie> listMovies = new ArrayList<Movie>();
//		listMovies.add(movie1);
//		listMovies.add(movie2);
//		listMovies.add(movie3);
//		listMovies.add(movie4);
//		listMovies.add(movie5);
//		listMovies.add(movie6);
		
		Netflix netflix = new Netflix();
		netflix.setId(102);
		netflix.setName("Imam");
		netflix.setMobile(9876543210L);
		netflix.setMovies(listMovies);
		
//		Netflix netflix = new Netflix();
//		netflix.setId(101);
//		netflix.setName("Raju");
//		netflix.setMobile(9876543210L);
//		netflix.setMovies(listMovies);
		
		NetflixMovieDao dao = new NetflixMovieDao();
//		dao.saveNetflixUser(netflix);
//		dao.saveMovie(movie6);
//		dao.findMovieById(1001);
//		dao.findAllNetflixUsers();
		dao.findAllMovies();
//		dao.updateNetflixUserById(netflix);
//		dao.updateMovieById(movie3);
//		dao.deleteMovieById(1001);  // Cannot delete or update a parent row: a foreign key constraint fails
//		dao.deleteNetflixUserById(102);
//		dao.addToWatchLater(netflix);
//		dao.findNetflixById(102);
//		dao.addToWatchLater(102, listMovies);
//		dao.deleteMovieById(102, 1006);
//		dao.assignMovieToUser(101, 1005);
		
	}
}