package app.sample.styledotmesample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.sample.styledotmesample.callback.OnItemClick;
import app.sample.styledotmesample.databinding.AdapterMemberBinding;
import app.sample.styledotmesample.model.Member;


public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ItemRowHolder> {

    private Context context;
    private List<Member> members;
    private OnItemClick onItemClick;

    /**
     * ConstructorX
     **/
    public MemberAdapter(Context pContext, OnItemClick onItemClick) {
        context = pContext;
        this.onItemClick = onItemClick;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return (null == members) ? 0 : members.size();
    }

    @NonNull
    @Override
    public ItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        AdapterMemberBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_member, parent, false);

        return new ItemRowHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRowHolder itemRowHolder, int position) {

        Member member = members.get(position);
        itemRowHolder.binding.setPosition(position);
        itemRowHolder.binding.setMember(member);
        itemRowHolder.binding.setOnItemClick(onItemClick);

    }

    public void setMembers(List<Member> newMembers) {
        if (this.members == null) {
            this.members = newMembers;
            final int positionStart = newMembers.size() + 1;
            notifyItemRangeInserted(positionStart, newMembers.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return members.size();
                }

                @Override
                public int getNewListSize() {
                    return newMembers.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return members.get(oldItemPosition).equals(newMembers.get(newItemPosition));
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Member item = newMembers.get(newItemPosition);
                    Member oldItem = members.get(oldItemPosition);
                    boolean areContentsTheSame = item.equals(oldItem);
                    if (areContentsTheSame) notifyDataSetChanged();
                    return areContentsTheSame;
                }
            });
            this.members = newMembers;
            result.dispatchUpdatesTo(this);
        }
    }

    /**
     * References to the views for each data item
     **/
    static class ItemRowHolder extends RecyclerView.ViewHolder {

        AdapterMemberBinding binding;

        ItemRowHolder(AdapterMemberBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

}