package AndrewWebServices;

import java.util.HashMap;
import java.util.Map;

/*
 * InMemoryDatabase is a fake for the AndrewWS database which is used to improve test efficiency.
 * Remember, fakes are fully functional classes with simplified implementation.
 * What is the simplest core functionality that we need for a functional database?
 * 
 * Hint: there are two methods you need to implement
 */
public class InMemoryDatabase extends Database {
    private Map<String,Integer> data;

    public InMemoryDatabase() {
        this.data = new HashMap<String,Integer>();
    }

    public void addAccount(String accountName, int password) {
        data.put(accountName, password);
    }

    @Override
    public int getPassword(String accountName) {
        if(data.containsKey(accountName)) {
            return data.get(accountName);
        }
        return -1;
    }
}