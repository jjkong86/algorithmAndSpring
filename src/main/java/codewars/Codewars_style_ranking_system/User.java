package codewars.Codewars_style_ranking_system;

//rank 공식 : 10 * d * d(d = 활동과 사용자의 순위 차이), 같은 랭크 : 3, 한단계 낮은 랭크 : 1, 2단계 이상 낮으면 0점
//랭크 범위는 -8 ~ 8 (16랭크)
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

		public Builder(int rank) {
			this.rank = rank;
			this.progress = 0;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("result > " + this.rank + "::" + this.progress);

	}

	public int rankFormula(int incProgress) throws Exception {
		if (incProgress < -8 || incProgress > 8 || incProgress == 0) throw new Exception("incProgress는 8보다 작거나 -8보다 커야하고 0이 아니어야함");
		int d = incProgress - this.rank;
		return d <= 0 ? (d <= -2 ? 0 : d * 2 + 3) : 10 * d * d;
	}

	public void rankUp(int point) throws Exception {
		System.out.println("rankUp progress > " + this.rank + "::" + this.progress + "::" + point);
		if (this.progress + point >= 100) {
			point = point - (100 - this.progress);
			int rank = this.rank;
			if (rank < 8) {
				this.rank = rank == -1 ? 1 : rank + 1;
				this.progress = 0;
				rankUp(point);
			} else {
				throw new Exception("랭크 8보다 높아 질 수 없음");
//				this.progress = 0;
			}
		} else {
			this.progress = this.progress + point;
		}
	}
}
