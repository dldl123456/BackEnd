package entity;
/**
 * 电影实体类
 * @author Administrator
 *
 */
public class Movie {
	private int movieId;
	private String movieName;
	private String movieDirect;
	private String movieMainactor;
	private String movieType;
	private String movieLanguage;
	private String movieShowtime;
	private String movieTimelength;
	private double moviePrice;
	private double movieScore;
	private String movieIntroduce;
	private int movieStatus;
	public Movie() {
		super();
	}
	public Movie(String movieName, String movieDirect, String movieMainactor, String movieType,
			String movieLanguage, String movieShowtime, String movieTimelength, double moviePrice, double movieScore,
			String movieIntroduce) {
		super();
		this.movieName = movieName;
		this.movieDirect = movieDirect;
		this.movieMainactor = movieMainactor;
		this.movieType = movieType;
		this.movieLanguage = movieLanguage;
		this.movieShowtime = movieShowtime;
		this.movieTimelength = movieTimelength;
		this.moviePrice = moviePrice;
		this.movieScore = movieScore;
		this.movieIntroduce = movieIntroduce;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDirect() {
		return movieDirect;
	}
	public void setMovieDirect(String movieDirect) {
		this.movieDirect = movieDirect;
	}
	public String getMovieMainactor() {
		return movieMainactor;
	}
	public void setMovieMainactor(String movieMainactor) {
		this.movieMainactor = movieMainactor;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public String getMovieShowtime() {
		return movieShowtime;
	}
	public void setMovieShowtime(String movieShowtime) {
		this.movieShowtime = movieShowtime;
	}
	public String getMovieTimelength() {
		return movieTimelength;
	}
	public void setMovieTimelength(String movieTimelength) {
		this.movieTimelength = movieTimelength;
	}
	public double getMoviePrice() {
		return moviePrice;
	}
	public void setMoviePrice(double moviePrice) {
		this.moviePrice = moviePrice;
	}
	public double getMovieScore() {
		return movieScore;
	}
	public void setMovieScore(double movieScore) {
		this.movieScore = movieScore;
	}
	public String getMovieIntroduce() {
		return movieIntroduce;
	}
	public void setMovieIntroduce(String movieIntroduce) {
		this.movieIntroduce = movieIntroduce;
	}
	public int getMovieStatus() {
		return movieStatus;
	}
	public void setMovieStatus(int movieStatus) {
		this.movieStatus = movieStatus;
	}
	/**
	 * 判断状态
	 * @return
	 */
	public String judgeMovieStatus() {
		if(getMovieStatus()==0) {
			return "敬请期待";
		}else if(getMovieStatus()==1){
			return "正在热映";
		}else {
			return "影片已下架";
		}
		
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieDirect=" + movieDirect
				+ ", movieMainactor=" + movieMainactor + ", movieType=" + movieType + ", movieLanguage=" + movieLanguage
				+ ", movieShowtime=" + movieShowtime + ", movieTimelength=" + movieTimelength + ", moviePrice="
				+ moviePrice + ", movieScore=" + movieScore + ", movieIntroduce=" + movieIntroduce + ", movieStatus="
				+ movieStatus + "]";
	}
	
}
