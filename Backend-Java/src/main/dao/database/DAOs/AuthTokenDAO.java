public class AuthTokenDAO implements iAuthTokenDAO {
    public static void main(String args[]) {

    }


}




// package edu.byu.cs.tweeter.server.dao.dynamoDB;

// import edu.byu.cs.tweeter.model.domain.AuthToken;
// import edu.byu.cs.tweeter.model.domain.User;
// import edu.byu.cs.tweeter.server.dao.iAuthTokenDAO;
// import edu.byu.cs.tweeter.server.dao.iDAOFactory;
// import edu.byu.cs.tweeter.server.dao.iUserDAO;
// import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
// import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
// import software.amazon.awssdk.enhanced.dynamodb.Key;
// import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
// import software.amazon.awssdk.regions.Region;
// import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

// import java.sql.Timestamp;
// import java.util.Date;
// import java.util.UUID;


// public class AuthTokenDAO implements iAuthTokenDAO {

//     public static void main(String args[]) {
//         iDAOFactory factory = new DynamoDBDAOFactory();

//         iAuthTokenDAO dao = factory.getAuthTokenDAO();

//         String userName = "@jim";
//         String password = "jimpassword";
//         String firsName = "jim";
//         String lastName = "jim";
//         String imageURL = "jimURL";

//         User user = new User(firsName, lastName, userName, imageURL);

//         AuthToken authToken = new AuthToken();
//         authToken.setToken("dba46f9a-a74c-4b85-a183-858d40eaab6d");
//         authToken.setDatetime("2022-11-21 08:19:08.469");

//         try {
//             AuthToken response = dao.login(user);

//             System.out.println("Response: ");
//             System.out.println(response.getDatetime());
//         } catch (Exception e) {
//             System.out.println("Error: ");
//             System.out.println(e.getMessage());
//         }
//     }

//     /*
//     //void logout(AuthToken authToken)
//     //AuthToken login(User user)
//     //boolean checkAuthToken(AuthToken authToken)
//     //AuthTokenObject getAuthTokenUser(AuthToken authToken)
//      */

//     // The active time limit for an authtoken to be OK. is 5 minutes.
//     private static final int authTokenTimeLimit = 10000;

//     private static final String TableName = "authtoken";

//     private static final String userAliasAttr = "userAlias";
//     private static final String userImageURLAttr = "userImageURL";
//     private static final String userFirstNameAttr = "userFirstName";
//     private static final String userLastNameAttr = "userLastName";
//     // Partition Key
//     private static final String authTokenAttr = "authToken";
//     private static final String timeStampAttr = "timeStamp";

//     // DynamoDB client
//     private static DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
//             .region(Region.US_EAST_1)
//             .build();

//     private static DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
//             .dynamoDbClient(dynamoDbClient)
//             .build();

//     private static boolean isNonEmptyString(String value) {
//         return (value != null && value.length() > 0);
//     }


//     @Override
//     public void logout(AuthToken authToken) throws Exception {

//         String authTokenValue = authToken.getToken();

//         DynamoDbTable<AuthTokenObject> table = enhancedClient.table(TableName, TableSchema.fromBean(AuthTokenObject.class));
//         Key key = Key.builder()
//                 .partitionValue(authTokenValue)
//                 .build();

//         AuthTokenObject object = table.getItem(key);

//         if (object != null) {
//             table.deleteItem(key);
//         }
//         else {
//             throw new Exception("AuthToken didn't match any in the database");
//         }
//     }

//     @Override
//     public AuthToken login(User user) {

//         // Generate a random AuthToken.
//         UUID uuid = UUID.randomUUID();
//         String authTokenValue = uuid.toString();

//         // 2021-03-24 16:48:05.591
//         Date date = new Date();
//         Timestamp ogTimeStamp = new Timestamp(date.getTime());
//         String timeStamp = ogTimeStamp.toString();

//         DynamoDbTable<AuthTokenObject> table = enhancedClient.table(TableName, TableSchema.fromBean(AuthTokenObject.class));

//         AuthTokenObject object = new AuthTokenObject();
//         object.setAuthToken(authTokenValue);
//         object.setTimeStamp(timeStamp);
//         object.setUserAlias(user.getAlias());
//         object.setUserImageURL(user.getImageUrl());
//         object.setUserFirstName(user.getFirstName());
//         object.setUserLastName(user.getLastName());
//         table.putItem(object);

//         AuthToken authToken = new AuthToken(authTokenValue, String.valueOf(timeStamp));

//         return authToken;
//     }

//     @Override
//     public boolean checkAuthToken(AuthToken authToken) throws Exception {

//         String authTokenValue = authToken.getToken();

//         DynamoDbTable<AuthTokenObject> table = enhancedClient.table(TableName, TableSchema.fromBean(AuthTokenObject.class));
//         Key key = Key.builder()
//                 .partitionValue(authTokenValue)
//                 .build();

//         AuthTokenObject object = table.getItem(key);

//         if (object == null) {
//             throw new Exception("AuthToken wasn't in the database");
//         }

//         String storedTimeStamp = object.getTimeStamp();
//         System.out.println("Stored timeStamp: ");
//         System.out.println(storedTimeStamp);


//         // yyyy-mm-dd hr:min:sec
//         // 2021-03-24 16:48:05.591
//         Date date = new Date();
//         Timestamp ogTimeStamp = new Timestamp(date.getTime());
//         String currentTimeStamp = ogTimeStamp.toString();
//         System.out.println("current timeStamp: ");
//         System.out.println(currentTimeStamp);


//         // Divide up the Time Stamps into dates and times
//         String storedDateTime[] = storedTimeStamp.split(" ", 2);
//         String storedDate[] = storedDateTime[0].split("-", 3);
//         String storedTime[] = storedDateTime[1].split(":", 3);

//         String currentDateTime[] = currentTimeStamp.split(" ", 2);
//         String currentDate[] = currentDateTime[0].split("-", 3);
//         String currentTime[] = currentDateTime[1].split(":", 3);

//         // For this course, the authtoken time will never be more than 24 hours, so the date should be the same.
//         if (!storedDateTime[0].equals(currentDateTime[0])) {
//             System.out.println("dates: ");
//             System.out.println(storedDateTime[0]);
//             System.out.println(currentDateTime[0]);
//             return false; // Bad authToken.
//         }

//         double time1 = (Double.valueOf(storedTime[0]) * 60) + Double.valueOf(storedTime[1]);
//         double time2 = (Double.valueOf(currentTime[0]) * 60) + Double.valueOf(currentTime[1]);

//         System.out.println("times: ");
//         System.out.println(time1);
//         System.out.println(time2);

//         System.out.println("authTokenLimit: ");
//         System.out.println(authTokenTimeLimit);


//         if (time2 - time1 <= authTokenTimeLimit) {
//             // If the time stamp is within bounds, update the timestamp to be the current timestamp.
//             object.setTimeStamp(currentTimeStamp);
//             table.updateItem(object);

//             return true;
//         }

//         // If the authtoken doesn't conform to the time limit:
//         return false;
//     }

//     @Override
//     public AuthTokenObject getAuthTokenUser(AuthToken authToken) throws Exception {

//         String authTokenValue = authToken.getToken();

//         DynamoDbTable<AuthTokenObject> table = enhancedClient.table(TableName, TableSchema.fromBean(AuthTokenObject.class));
//         Key key = Key.builder()
//                 .partitionValue(authTokenValue)
//                 .build();

//         AuthTokenObject object = table.getItem(key);

//         if (object == null) {
//             throw new Exception("AuthToken wasn't in the database");
//         }

//         return object;
//     }
// }

