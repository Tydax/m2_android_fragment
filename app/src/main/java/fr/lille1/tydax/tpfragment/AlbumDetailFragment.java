package fr.lille1.tydax.tpfragment;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import fr.lille1.tydax.tpfragment.album.Album;

/**
 * A fragment representing a single Album detail screen.
 * This fragment is either contained in a {@link AlbumListActivity}
 * in two-pane mode (on tablets) or a {@link AlbumDetailActivity}
 * on handsets.
 */
public class AlbumDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Album mSelectedAlbum;

    private TextView mTitle;

    private TextView mArtist;

    private TextView mYear;

    private ListView mTracks;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AlbumDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mSelectedAlbum = Album.TEMPLATE.get(getArguments().getInt(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mSelectedAlbum.getTitle());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.album_detail, container, false);

        mTitle = (TextView) rootView.findViewById(R.id.album_artist);
        mArtist = (TextView) rootView.findViewById(R.id.album_artist);
        mYear = (TextView) rootView.findViewById(R.id.album_year);
        mTracks = (ListView) rootView.findViewById(R.id.album_tracks);

        // Show the dummy content as text in a TextView.
        if (mSelectedAlbum != null) {
            updateViewsWithData(rootView);
        }

        return rootView;
    }

    protected void updateViewsWithData(View rootView) {
        CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) rootView.findViewById(R.id.toolbar_layout);
        appBarLayout.setBackground(ContextCompat.getDrawable(getActivity(), mSelectedAlbum.getCover()));
        mTitle.setText(mSelectedAlbum.getTitle());
        mArtist.setText(mSelectedAlbum.getArtist());
        mYear.setText(mSelectedAlbum.getYear());
        final ListAdapter adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, mSelectedAlbum.getTracks());
        mTracks.setAdapter(adapter);
    }
}
