// Generated code from Butter Knife. Do not modify!
package org.qinshuihepan.bbs.ui.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class PostsFragment$$ViewInjector {
  public static void inject(Finder finder, final org.qinshuihepan.bbs.ui.fragment.PostsFragment target, Object source) {
    View view;
    view = finder.findById(source, 2131361797);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361797' for field 'mListView' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.mListView = (org.qinshuihepan.bbs.view.PageListView) view;
    view = finder.findById(source, 2131361798);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361798' for field 'mSwipeLayout' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.mSwipeLayout = (android.support.v4.widget.SwipeRefreshLayout) view;
  }

  public static void reset(org.qinshuihepan.bbs.ui.fragment.PostsFragment target) {
    target.mListView = null;
    target.mSwipeLayout = null;
  }
}
