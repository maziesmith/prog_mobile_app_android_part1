package course.labs.fragmentslab;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

public class MainActivity extends Activity implements
		FriendsFragment.SelectionListener {

	private static final String TAG = "Lab-Fragments";
	
	private static final String FRIENDS_FRAG_TAG = "FRIENDS_FRAG_TAG";
	private static final String FEED_FRAG_TAG = "FEED_FRAG_TAG";

	private FriendsFragment mFriendsFragment;
	private FeedFragment mFeedFragment;
	
	private final String CURRENT_CHOOSED_FRIEND = "CURRENT_CHOOSED_FRIEND";
	private int currentChoosedFriend = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		// If the layout is single-pane, create the FriendsFragment 
		// and add it to the Activity

		if (savedInstanceState == null) {
			if (!isInTwoPaneMode()) {
				
				mFriendsFragment = new FriendsFragment();
	
				//TODO 1 - add the FriendsFragment to the fragment_container
				FragmentManager manager = getFragmentManager();
				FragmentTransaction trans = manager.beginTransaction();
				trans.add(R.id.fragment_container, mFriendsFragment, FRIENDS_FRAG_TAG);
				trans.commit();						
	
			} else {
	
				// Otherwise, save a reference to the FeedFragment for later use
	
				mFeedFragment = (FeedFragment) getFragmentManager()
						.findFragmentById(R.id.feed_frag);
			}
		} else {
			if (!isInTwoPaneMode()) {
				
				FragmentManager manager = getFragmentManager();
				
				if (savedInstanceState.containsKey(FRIENDS_FRAG_TAG))
					mFriendsFragment = (FriendsFragment)manager.getFragment(savedInstanceState, FRIENDS_FRAG_TAG);	
				
				if (savedInstanceState.containsKey(FEED_FRAG_TAG))
					mFeedFragment = (FeedFragment)manager.getFragment(savedInstanceState, FEED_FRAG_TAG);	
	
			} else {
	
				// Otherwise, save a reference to the FeedFragment for later use
	
				mFeedFragment = (FeedFragment) getFragmentManager()
						.findFragmentById(R.id.feed_frag);
			}
		}

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_CHOOSED_FRIEND, currentChoosedFriend);
    }
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction transaction = fm.beginTransaction();
//        if (fm.findFragmentById(R.id.friends_frag) == null) {
//            // instantiate fragment and add to view
//        	mFriendsFragment = new FriendsFragment();
//            transaction.add(R.id.fragment_container, mFriendsFragment );
//        } else {
//            // fragment already exists, we re-attahced it
//        	mFriendsFragment = (FriendsFragment)fm.findFragmentById(R.id.friends_frag);
//            transaction.detach(mFriendsFragment);
//            transaction.attach(mFriendsFragment);
//        }
//        if (fm.findFragmentById(R.id.feed_frag) != null) {
//        	mFeedFragment = (FeedFragment)fm.findFragmentById(R.id.feed_frag);
//            transaction.detach(mFeedFragment);
//        }
//        transaction.commit();
//        
        currentChoosedFriend = savedInstanceState.getInt(CURRENT_CHOOSED_FRIEND, -1);
        onItemSelected(currentChoosedFriend);
    }
	
	@Override
	protected void onStart() {
		Log.i(TAG, "Entered onStart");
		
		super.onStart();
	}

	@Override
    protected void onRestart() {
    	Log.i(TAG, "Entered onRestart");
    	
    	super.onRestart();
    }

	@Override
    protected void onResume() {
    	Log.i(TAG, "Entered onResume");
    	
    	super.onResume();
    }

	@Override
    protected void onPause() {
    	Log.i(TAG, "Entered onPause");
    	
    	super.onPause();
    }

	@Override
    protected void onStop() {
    	Log.i(TAG, "Entered onStop");
    	
    	super.onStop();
    }

	@Override
    protected void onDestroy() {
    	Log.i(TAG, "Entered onDestroy");
    	
    	super.onDestroy();
    }
	// If there is no fragment_container ID, then the application is in
	// two-pane mode

	private boolean isInTwoPaneMode() {

		return findViewById(R.id.fragment_container) == null;
	
	}

	// Display selected Twitter feed

	public void onItemSelected(int position) {

		Log.i(TAG, "Entered onItemSelected(" + position + ")");
		currentChoosedFriend = position;

		// If there is no FeedFragment instance, then create one

		if (mFeedFragment == null)
			mFeedFragment = new FeedFragment();

		// If in single-pane mode, replace single visible Fragment

		if (!isInTwoPaneMode()) {

			//TODO 2 - replace the fragment_container with the FeedFragment
			FragmentTransaction trans = getFragmentManager().beginTransaction();
			trans.replace(R.id.fragment_container, mFeedFragment, FEED_FRAG_TAG);
			trans.addToBackStack(null);
			trans.commit();
			// execute transaction now
			getFragmentManager().executePendingTransactions();

		}

		// Update Twitter feed display on FriendFragment
		mFeedFragment.updateFeedDisplay(position);

	}

}
