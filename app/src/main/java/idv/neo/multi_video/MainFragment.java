package idv.neo.multi_video;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import idv.neo.widget.AutoTextureVideoView;
import idv.neo.widget.MapLayoutManager;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {
    private String TAG = MainFragment.class.getSimpleName();

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Context context = container.getContext();
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final ImageButton tile1 = (ImageButton) root.findViewById(R.id.tile_1);
        final ImageButton tile4 = (ImageButton) root.findViewById(R.id.tile_4);
        final ImageButton tile6 = (ImageButton) root.findViewById(R.id.tile_6);
        final ImageButton tile9 = (ImageButton) root.findViewById(R.id.tile_9);
        final RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new MapLayoutManager(context, MapLayoutManager.HORIZONTAL, new int[][]{
                new int[]{0}
        }));
        recyclerView.setAdapter(new VideoAdapter());
        recyclerView.setOnScrollListener(
                new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                            final MapLayoutManager lm = (MapLayoutManager) recyclerView.getLayoutManager();
                            if (!lm.isSnappedToFirstVisibleItem()) {
                                recyclerView.smoothScrollToPosition(lm.findOptimalFirstVisibleItemPosition());
                            }
                        }
                    }
                }
        );

        tile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MapLayoutManager) recyclerView.getLayoutManager()).setChildMap(new int[][]{
                        new int[]{0}
                });
            }
        });
        tile4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MapLayoutManager) recyclerView.getLayoutManager()).setChildMap(new int[][]{
                        new int[]{0, 1},
                        new int[]{2, 3},
                });
            }
        });

        tile6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MapLayoutManager) recyclerView.getLayoutManager()).setChildMap(new int[][]{
                        new int[]{0, 0, 1},
                        new int[]{0, 0, 2},
                        new int[]{3, 4, 5},
                });
            }
        });
        tile9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MapLayoutManager) recyclerView.getLayoutManager()).setChildMap(new int[][]{
                        new int[]{0, 1, 2},
                        new int[]{3, 4, 5},
                        new int[]{6, 7, 8},
                });
            }
        });
        return root;
    }

    public final class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
        private final String[] sVideoPaths = new String[]{
                "http://cdn.looklook.space/videos/0/90215/90215.240p.ts",
                "http://cdn.looklook.space/videos/0/93251/93251.240p.ts",
                "http://cdn.looklook.space/videos/0/92857/92857.240p.ts",
                "http://cdn.looklook.space/videos/0/98968/98968.240p.ts",
                "http://cdn.looklook.space/videos/0/96078/96078.240p.ts",
                "http://cdn.looklook.space/videos/0/99755/99755.240p.ts",
                "http://cdn.looklook.space/videos/1/101440/101440.240p.ts",
                "http://cdn.looklook.space/videos/1/101876/101876.240p.ts",
                "http://cdn.looklook.space/videos/0/98025/98025.240p.ts",
                "http://cdn.looklook.space/videos/0/97733/97733.240p.ts",
                "http://cdn.looklook.space/videos/0/98395/98395.240p.ts",
                "http://cdn.looklook.space/videos/0/82108/82108.240p.ts",
                "http://cdn.looklook.space/videos/0/90277/90277.240p.ts",
                "http://cdn.looklook.space/videos/0/82214/82214.240p.ts",
                "http://cdn.looklook.space/videos/1/101424/101424.240p.ts",
                "http://cdn.looklook.space/videos/0/98247/98247.240p.ts",
                "http://cdn.looklook.space/videos/0/97435/97435.240p.ts",
                "http://cdn.looklook.space/videos/0/99747/99747.240p.ts",
                "http://cdn.looklook.space/videos/0/98353/98353.240p.ts",
                "http://cdn.looklook.space/videos/0/82651/82651.240p.ts",
                "http://cdn.looklook.space/videos/0/98954/98954.240p.ts",
                "http://cdn.looklook.space/videos/0/90555/90555.240p.ts",
                "http://cdn.looklook.space/videos/1/101044/101044.240p.ts",
                "http://cdn.looklook.space/videos/0/92801/92801.240p.ts",
                "http://cdn.looklook.space/videos/0/99502/99502.240p.ts",
                "http://cdn.looklook.space/videos/0/97798/97798.240p.ts",
                "http://cdn.looklook.space/videos/0/82738/82738.240p.ts",
                "http://cdn.looklook.space/videos/0/94849/94849.240p.ts",
                "http://cdn.looklook.space/videos/0/82495/82495.240p.ts",
                "http://cdn.looklook.space/videos/1/103239/103239.240p.ts",
        };

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false)
            );
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final String path = sVideoPaths[position];
            holder.info.setText(path);
            holder.path = path;
            holder.itemView.removeCallbacks(holder);
            holder.itemView.postDelayed(holder, 500);
        }

        @Override
        public void onViewRecycled(ViewHolder holder) {
            super.onViewRecycled(holder);
        }

        @Override
        public int getItemCount() {
            return sVideoPaths.length;
        }

        public final class ViewHolder extends RecyclerView.ViewHolder implements Runnable {
            String path;
            TextView info;
            AutoTextureVideoView video;

            public ViewHolder(View itemView) {
                super(itemView);
                video = (AutoTextureVideoView) itemView.findViewById(R.id.video);
                info = (TextView) itemView.findViewById(R.id.info);
            }

            @Override
            public void run() {
                video.setAspectRatio(1);
                video.setVideoPath(path);
            }
        }
    }
}

