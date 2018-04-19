/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program_ptiseis;

// Κλάση που περιλαμβάνει πληροφορίες για το πλήθος των αποστολών που έχει ένας 
// πιλότος ανά άσκηση και πριν πόσες ημέρες συνέβη
public class ApostoliPerPilot {
    String name;
    String askisiId;
    int count;
    int days;

    public ApostoliPerPilot(String name, String askisiId, int count, int days) {
        this.name = name;
        this.askisiId = askisiId;
        this.count = count;
        this.days = days;
    }

    public String getAskisiId() {
        return askisiId;
    }

    public int getCount() {
        return count;
    }

    public int getDays() {
        return days;
    }
    
}
