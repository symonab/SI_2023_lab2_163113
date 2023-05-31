import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    public List<User> setUserList(){
    List<User> userList = new ArrayList<>();
    User user1 = new User("john", "Password123!", "john@gmail.com");
    User user2 = new User("jane", "Password ?", "jane@gmail.com");
    User user3 = new User("karl", "karl", "karl@gmailcom");
    User user4 = new User("kate", null, "kate@gmail.com");
    User user5 = new User("lora", "Pass", "lora@gmail.com");

    userList.add(user1);
    userList.add(user2);
    userList.add(user3);
    userList.add(user4);
    userList.add(user5);


        return userList;
    }
    @Test
    void everyBranchTest() {
        RuntimeException ex;
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(null,setUserList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!")); //ako user e null
        assertFalse(SILab2.function(new User("lora", "Pass", "lora@gmail.com"),setUserList())); 
        assertFalse(SILab2.function(setUserList().get(0),setUserList())); 
        assertFalse(SILab2.function(setUserList().get(1),setUserList())); 
        assertFalse(SILab2.function(setUserList().get(2),setUserList())); 
        assertFalse(SILab2.function(setUserList().get(2),setUserList())); 
        assertTrue(SILab2.function(new User("ann", "Password123??", "ann@gmail.com"),setUserList())); 
    }
    @Test
    void multipleCondition(){
        RuntimeException ex;
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(null,setUserList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!")); 
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(setUserList().get(3),setUserList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!")); 
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(new User("jade", "Password???", null),setUserList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!")); 
        assertTrue(SILab2.function(new User("ann", "Password123??", "ann@gmail.com"),setUserList())); 

    }

}