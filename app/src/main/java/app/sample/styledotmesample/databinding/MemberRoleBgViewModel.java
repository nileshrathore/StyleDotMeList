package app.sample.styledotmesample.databinding;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import app.sample.AppApplication;
import app.sample.styledotmesample.R;
import app.sample.styledotmesample.constant.AppConstant;

public class MemberRoleBgViewModel {

    @BindingAdapter({"bind:memberRoleBg"})
    public static void setBg(TextView view, String role) {
        try {
            if (AppConstant.MEMBER_ROLE_TEAM_LEADER.equalsIgnoreCase(role)){
                view.setBackground(AppApplication.getInstance().getResources().getDrawable(R.drawable.role_team_leader_badge_bg));
            } else if (AppConstant.MEMBER_ROLE_MODERATOR.equalsIgnoreCase(role)) {
                view.setBackground(AppApplication.getInstance().getResources().getDrawable(R.drawable.role_moderator_badge_bg));
            } else {
                view.setBackground(AppApplication.getInstance().getResources().getDrawable(R.drawable.role_member_badge_bg));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}