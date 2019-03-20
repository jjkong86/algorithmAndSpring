package codewars.Codewars_style_ranking_system;

//rank 공식 : 10 * d * d(d = 활동과 사용자의 순위 차이), 같은 랭크 : 3, 한단계 낮은 랭크 : 1, 2단계 이상 낮으면 0점
//랭크 범위는 -8 ~ 8 (15랭크)
public class User {
	int rank;
	int progress;

	public static class Builder {
		private int rank;
		private int progress;

		public Builder(int rank, int progress) {
			this.rank = rank;
			this.progress = progress;
		}

		public Builder() {
			this.rank = -8;
			this.progress = 0;
		}

		public User build() {
			return new User(this);
		}
	}

	public User(Builder builder) {
		this.rank = builder.rank;
		this.progress = builder.progress;
	}

	public User() {
		this.rank = -8;
		this.progress = 0;
	}

	public void incProgress(int incProgress) {
		/*
		 * rank - incProgress 차이 계산 하고 공식 대입
		 */
		System.out.println("연산 > " + this.rank + "::" + this.progress + "::" + incProgress);
		try {
			int point = rankFormula(incProgress);
			rankUp(point);
			System.out.println("result > " + this.rank + "::" + this.progress);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	public int rankFormula(int incProgress) throws Exception {
		if (incProgress < -8 || incProgress > 8 || incProgress == 0) throw new IllegalArgumentException();
		if (this.rank == 1 && incProgress == -1) return 1;
		
		int d = 0;
		if (this.rank < 0 && incProgress > 0) d = incProgress - this.rank - 1;
		else d = incProgress - this.rank;
		return d <= 0 ? (d <= -2 ? 0 : d * 2 + 3) : 10 * d * d;
	}

	public void rankUp(int point) throws Exception {
		if (rank >= 8) {
			this.progress = 0;
			return;
		}
		System.out.println("rankUp progress > " + this.rank + "::" + this.progress + "::" + point);
		if (this.progress + point >= 100) {
			point = point - (100 - this.progress);
			this.rank = rank == -1 ? 1 : rank + 1;
			this.progress = 0;
			rankUp(point);
		} else {
			this.progress = this.progress + point;
		}
	}
}
