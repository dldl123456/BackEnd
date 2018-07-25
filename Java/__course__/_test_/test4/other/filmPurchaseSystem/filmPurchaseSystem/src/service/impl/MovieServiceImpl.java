package service.impl;

import dao.MovieDao;
import dao.impl.MovieDaoImpl;
import entity.Movie;
import service.MovieService;
import view.AdminView;
import view.MovieView;

public class MovieServiceImpl implements MovieService {
	Movie movie = new Movie();
	MovieDao md = new MovieDaoImpl();
	@Override
	public void adminFunctionAddMovie() throws Exception {
		movie=MovieView.MovieAddPage();
		try {
			md.addMovie(movie);
			System.out.println("\n电影添加成功！！！");
			System.out.println("请选择其他操作：");
			AdminView.adminOperateMoviePage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void adminFunctionDeleteMovie() throws Exception {
		MovieView.MovieDeletePage();
	}

	@Override
	public void adminFunctionSeeAllMovie() throws Exception {
		MovieView.MovieSeeAllPage();
		AdminView.adminOperateMoviePage();
	}

	@Override
	public void aadminFunctionSeeMovie() throws Exception {
		MovieView.MovieSeePage();
		AdminView.adminOperateMoviePage();
	}

	@Override
	public void adminFunctionUpdateMovieStatus() throws Exception {
		MovieView.MovieUpdateStatus();
	}

	@Override
	public void adminFunctionUpdateMovieScore() throws Exception {
		MovieView.MovieUpdateScore();
	}

	@Override
	public void movieRankListFunction() throws Exception {
		MovieView.movieRankListPage();
		AdminView.adminOperateMoviePage();
	}

}
