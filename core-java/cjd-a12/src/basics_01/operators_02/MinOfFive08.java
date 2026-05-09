package basics_01.operators_02;

public class MinOfFive08 {

	public static void main(String[] args){
		int a=25,b=38,c=15,d=40,e=12;
		int min=(a<b)?
			((a<c)?
				(a<d)?(a<e?a:e):(d<e?d:e)
				:(c<d)?(c<e?c:e):(d<e?d:e))
			:((b<c)?
				(b<d)?(b<e?b:e):(d<e?d:e)
				:(c<d)?(c<e?c:e):(d<e?d:e));
		System.out.println(min);//12
	}
}