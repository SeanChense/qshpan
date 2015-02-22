// Generated code from Butter Knife. Do not modify!
package org.qinshuihepan.bbs.ui.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class PostsAdapter$Holder$$ViewInjector {
  public static void inject(Finder finder, final org.qinshuihepan.bbs.ui.adapter.PostsAdapter.Holder target, Object source) {
    View view;
    view = finder.findById(source, 2131361807);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361807' for field 'comment_count' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.comment_count = (android.widget.TextView) view;
    view = finder.findById(source, 2131361803);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361803' for field 'time' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.time = (android.widget.TextView) view;
    view = finder.findById(source, 2131361801);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361801' for field 'title' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.title = (android.widget.TextView) view;
    view = finder.findById(source, 2131361800);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361800' for field 'left_strip' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.left_strip = (android.widget.ImageView) view;
    view = finder.findById(source, 2131361806);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361806' for field 'content' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.content = (android.widget.TextView) view;
  }

  public static void reset(org.qinshuihepan.bbs.ui.adapter.PostsAdapter.Holder target) {
    target.comment_count = null;
    target.time = null;
    target.title = null;
    target.left_strip = null;
    target.content = null;
  }
}
