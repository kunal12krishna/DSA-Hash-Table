package P9_TwoSumVariants;

public class Transaction {

    int id;
    int amount;
    String merchant;

    public Transaction(int id, int amount, String merchant) {
        this.id = id;
        this.amount = amount;
        this.merchant = merchant;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Amount: " + amount +
                ", Merchant: " + merchant;
    }
}