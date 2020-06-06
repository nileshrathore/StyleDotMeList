package app.sample.styledotmesample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.LinearLayout;
import android.widget.Toast;

import app.sample.styledotmesample.databinding.ActivityMainBinding;
import app.sample.styledotmesample.model.Member;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MemberAdapter memberAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initWidgets();
        setMemberAdapter();
        subscribeToMembers();
    }

    private void initWidgets() {
        AppUtil.setLightWhiteStatusBar(this);

        AppUtil.setHtmlText(binding.header.tvTitle, "Task <b>Members</b>");
        AppUtil.setHtmlText(binding.header.tvMessage, "Science Fair 2020 / <b>Team Alpha</b>");

    }

    private void setMemberAdapter() {
        memberAdapter = new MemberAdapter(this, this::handleAdapterClicks);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        binding.rvMembers.setLayoutManager(layoutManager);
        binding.rvMembers.setHasFixedSize(false);
        binding.rvMembers.setNestedScrollingEnabled(false);
        binding.rvMembers.setAdapter(memberAdapter);

    }

    private void handleAdapterClicks(int position, Object object) {
        Member member = (Member) object;
        Toast.makeText(this, "I'm " + member.getName(), Toast.LENGTH_SHORT).show();
    }

    private void subscribeToMembers() {
        memberAdapter.setMembers(AppUtil.getDummyListOfMembers(this));
    }

}