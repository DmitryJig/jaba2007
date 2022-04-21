package course3.lesson1.gusev;

public class Stats <T extends Number>{
    private T[] nums;

    public Stats(T... nums) {
        this.nums = nums;
    }

    public double avg(){
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    public boolean isSaveAvg(Stats<?> stats) {
        //знак вопроса означает что можно передать любой тип, тоже можно написать extends Number
        // но это излишне так как Stats уже ограничен

        return Math.abs(this.avg() - stats.avg()) < 0.0001;
        // СРАВНИВАТЬ ДАБЛ ЧЕРЕЗ == НЕЛЬЗЯ!!!!!!!!!
        // Деньги считаем только в BigDecimal

    }
}
