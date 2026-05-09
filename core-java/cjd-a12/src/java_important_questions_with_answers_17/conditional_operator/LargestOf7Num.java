package java_important_questions_with_answers_17.conditional_operator;

public class  LargestOf7Num{
	
	public static void main(String[] args) {
		int a=10, b=20, c=30, d=40, e=50, f=60, g=70;
		System.out.println("Given numbers are A : "+ a +", B : "+ b +", C : "+ c +", D : "+ d +", E : "+ e +", F : "+ f +", G : "+ g);
		int res=
			(a>b)?
				(a>c)?
					(a>d)?
						(a>e)?
							(a>f)?
								(a>g?a:g)
								:(f>g?f:g)
							:(e>f)?
								(e>g?e:g)
								:(f>g?f:g)
						:(d>e)?
							(d>f)?
								(d>g?d:g)
								:(f>g?f:g)
							:(e>f)?
								(e>g?e:g)
								:(f>g?f:g)
					:(c>d)?
						(c>e)?
							(c>f)?
								(c>g?c:g)
								:(f>g?f:g)
							:(e>f)?
								(e>g?e:g)
								:(f>g?f:g)
						:(d>e)?
							(d>f)?
								(d>g?d:g)
								:(f>g?f:g)
							:(e>f)?
								(e>g?e:g)
								:(f>g?f:g)
				:(b>c)?
					(b>d)?
						(b>e)?
							(b>f)?
								(b>g?b:g)
								:(f>g?f:g)
							:(e>f)?
								(e>g?e:g)
								:(f>g?f:g)
						:(d>e)?
							(d>f)?
								(d>g?d:g)
								:(f>g?f:g)
							:(e>f)?
								(e>g?e:g)
								:(f>g?f:g)
					:(c>d)?
						(c>e)?
							(c>f)?
								(c>g?c:g)
								:(f>g?f:g)
							:(e>f)?
								(e>g?e:g)
								:(f>g?f:g)
						:(d>e)?
							(d>f)?
								(d>g?d:g)
								:(f>g?f:g)
							:(e>f)?
								(e>g?e:g)
								:(f>g?f:g);
		System.out.println("Largest of given 7 numbers : "+res);
	}
}