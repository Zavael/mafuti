package sk.badand.mafuti.model.player;

/**
 * Created by abadinka.
 */
public class Fitness {
    public static final double INJURY_LEVEL = 60.0;
    public static final double TIREDNESS_LEVEL = 80.0;
    public static final int HEALING_RATE_PER_WEEK = 5; //TODO modify by player strength or other perks?
    private double condition; // in percent
    private FitnessStatus status;

    public Fitness(double condition) {
        this.condition = condition;
        updateStatus();
    }

    public String getKey() {
        return status.key;
    }

    public FitnessStatus getStatus() {
        return status;
    };

    public double getRatingAffect() {
        return status.ratingAffect;
    }

    public double getCondition() {
        return condition;
    }

    /**
     * Heal specific amount of energy
     * @param energy
     */
    public void heal(double energy) {
        this.condition += energy;
        updateStatus();
    }

    public int getApproxWeeksToHeal() {
        return INJURY_LEVEL > condition
                ? (int) ((INJURY_LEVEL - condition) / HEALING_RATE_PER_WEEK) +1
                : 0;
    }

    public void addInjury() {
        //TODO add injury and update status
    }

    private void updateStatus() {
        if (condition <= INJURY_LEVEL) {
            status = FitnessStatus.INJURED;
        } else if (condition <= TIREDNESS_LEVEL) {
            status = FitnessStatus.TIRED;
        } else {
            status = FitnessStatus.HEALTHY;
        }
    }

    @Override
    public String toString() {
        return "Fitness{" +
                "condition=" + condition +
                ", status=" + status +
                '}';
    }
}
