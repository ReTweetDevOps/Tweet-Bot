package bot;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.List;
import twitter4j.*;

public class Bot{

    public static void main(String[] args) 
    {
         NewTweet();
        gettimline();
    }
       
        public static void NewTweet()
        {   //maikng a tweet from your account
            Twitter twitter = TwitterFactory.getSingleton();
            String mytweet="Hello, this UPES DevOps Bot";
            try
            {
            Status status = twitter.updateStatus(mytweet);
                System.out.println("successful"+status.getText());
            }
            catch(TwitterException e){
                e.printStackTrace();
            }
    }
    public static void gettimline(){
         try {
            // gets Twitter instance with default credentials
            Twitter twitter = new TwitterFactory().getInstance();
            User user = twitter.verifyCredentials();
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");//getting all the latest tweets from your timeline
            for (Status status : statuses) {
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
         }
}
