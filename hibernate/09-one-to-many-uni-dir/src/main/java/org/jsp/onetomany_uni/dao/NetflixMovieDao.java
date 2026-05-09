package org.jsp.onetomany_uni.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomany_uni.dto.Movie;
import org.jsp.onetomany_uni.dto.Netflix;

public class NetflixMovieDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}

	public void saveNetflixUser(Netflix netflix) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(netflix);
		transaction.commit();
		System.out.println("Netflix user saved successfully");
	}

	public void saveMovie(Movie movie) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.merge(movie);
		transaction.commit();
		System.out.println("Movie saved successfully");
	}

	public void findNetflixById(int netflixId) {
		EntityManager manager = getEntityManager();

		Netflix netflix = manager.find(Netflix.class, netflixId);
		if (netflix != null) {
			System.out.println(netflix);
		} else {
			System.out.println("Netflix not found");
		}
	}

	public void findMovieById(int movieId) {
		EntityManager manager = getEntityManager();

		Movie movie = manager.find(Movie.class, movieId);
		if (movie != null) {
			System.out.println(movie);
		} else {
			System.out.println("Movie not found");
		}
	}

	public void findAllNetflixUsers() {
		EntityManager manager = getEntityManager();

		Query query = manager.createQuery("select netflix from Netflix netflix");
		List<Netflix> netflixs = query.getResultList();

		if (!netflixs.isEmpty()) {
			for (Netflix netflix : netflixs) {
				System.out.println(netflix);
			}
		} else {
			System.out.println("There are no user found");
		}
	}

	public void findAllMovies() {
		EntityManager manager = getEntityManager();

		Query query = manager.createQuery("select movie from Movie movie");
		List<Movie> movies = query.getResultList();

		if (!movies.isEmpty()) {
			for (Movie movie : movies) {
				System.out.println(movie);
			}
		} else {
			System.out.println("There are no movie found");
		}
	}

	public void updateNetflixUserById(Netflix netflix) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Netflix netflixFromDatabase = manager.find(Netflix.class, netflix.getId());
		if (netflixFromDatabase != null) {
			transaction.begin();
			manager.merge(netflix);
			transaction.commit();
			System.out.println("Netflix user updated successfully");
		} else {
			System.out.println("The given user id " + netflix.getId() + " is not found");
		}
	}

	public void updateMovieById(Movie movie) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Movie movieFromDatabase = manager.find(Movie.class, movie.getId());
		if (movieFromDatabase != null) {
			transaction.begin();
			manager.merge(movie);
			transaction.commit();
			System.out.println("Movie updated successfully");
		} else {
			System.out.println("The given movie id " + movie.getId() + " is not found");
		}
	}

	public void deleteNetflixUserById(int netflixUserId) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Netflix netflix = manager.find(Netflix.class, netflixUserId);

		if (netflix != null) {
			transaction.begin();
			manager.remove(netflix);
			transaction.commit();
			System.out.println("Netflix user deleted successfully");
		} else {
			System.out.println("The given netflix user " + netflixUserId + " is not found");
		}
	}

	public void deleteMovieById(int movieId) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Movie movie = manager.find(Movie.class, movieId);
		if (movie != null) {
			transaction.begin();
			manager.remove(movie);
			transaction.commit();
			System.out.println("Movie deleted successfully");
		} else {
			System.out.println("The given movie id " + movieId + " is not found");
		}
	}

	public void addToWatchLater(int netflixId, List<Movie> movie) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		ListIterator<Movie> listIterator = movie.listIterator();
		ArrayList<Integer> movieIds = new ArrayList<Integer>();
		while (listIterator.hasNext()) {
			movieIds.add(listIterator.next().getId());
		}

		Query query = manager.createQuery("select movie from Movie movie");
		List<Movie> movies = query.getResultList();
		ArrayList<Integer> databaseMovieIds = new ArrayList<Integer>();
		listIterator = movies.listIterator();
		while (listIterator.hasNext()) {
			databaseMovieIds.add(listIterator.next().getId());
		}
		boolean b = true;
		int movieId = 0;
		ListIterator<Integer> listIteratorInt = movieIds.listIterator();
		while (listIteratorInt.hasNext()) {
			int compare = listIteratorInt.next();
			if (databaseMovieIds.contains(compare)) {
				b = false;
				System.out.println("The given movie id already exists : " + compare);
				System.out.println("Please enter different movie id");
				movieId = compare;
				break;
			}
		}

		Netflix netflix = manager.find(Netflix.class, netflixId);

		if (netflix != null && b) {
			movie.addAll(netflix.getMovies());
			netflix.setMovies(movie);

			transaction.begin();
			manager.merge(netflix);
			transaction.commit();
			System.out.println("Added to watch later successfully");
		} else {
			System.out.println("either user " + netflixId + " not found or movie id " + movieId + " already exist");
		}

	}
//	public void addToWatchLater(int netflixId, List<Movie> movie) {
//		EntityManager manager = getEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//		
//		Netflix netflix = manager.find(Netflix.class, netflixId);
//		
//		if(netflix != null) {
//			Set<Movie> setMovieDatabase = new HashSet<Movie>(netflix.getMovies());
//			Set<Integer> movieIds = new HashSet<Integer>();
//			Iterator<Movie> iterator = setMovieDatabase.iterator();
//			while(iterator.hasNext()) {
//				movieIds.add(iterator.next().getId());
//			}
//			
//			setMovieDatabase.addAll(movie); //Adding new as well as old movies in one collection
//			List<Movie> listMovieDatabase = new ArrayList<Movie>(setMovieDatabase);
//			netflix.setMovies(listMovieDatabase);
//			
//			transaction.begin();
//			manager.merge(netflix);
//			transaction.commit();
//			System.out.println("Added to watch later successfully");
//		}
//		else {
//			System.out.println("user not found");
//		}
//	}

	public void deleteMovieById(int netflixId, int movieId) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Netflix netflix = manager.find(Netflix.class, netflixId);
		Movie movie = manager.find(Movie.class, movieId);

		if (netflix != null && movie != null) {
			List<Movie> movies = netflix.getMovies();
			if (movies.contains(movie)) {
				movies.remove(movie);
				transaction.begin();
				manager.merge(netflix);
				transaction.commit();
				System.out.println("Movie id : " + movieId + " deleted from Netflix id : " + netflixId);
			}
		}
		else {
			System.out.println("Either Netflix Id : "+ netflixId +" or Mivie Id : "+ movieId +" is not available");
		}
	}

	public void assignMovieToUser(int netflixId, int movieId) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Netflix netflix = manager.find(Netflix.class, netflixId);
		Movie movie = manager.find(Movie.class, movieId);

		if (netflix != null && movie != null) {
			List<Movie> movies = netflix.getMovies();
			if (!movies.contains(movie)) {
				movies.add(movie);
				netflix.setMovies(movies);
				transaction.begin();
				manager.merge(netflix);
				transaction.commit();
				System.out.println("Movie id "+ movieId +" has aasigned to the Netflix id "+ netflixId +" successfully");
			} else {
				System.out.println("Movie id : "+ movieId +" already assigned to the Netflix : "+ netflixId);
			}
		}
	}
}