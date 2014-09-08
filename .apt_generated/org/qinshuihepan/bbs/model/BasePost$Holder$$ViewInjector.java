// Generated code from Butter Knife. Do not modify!
package org.qinshuihepan.bbs.model;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class BasePost$Holder$$ViewInjector {
  public static void inject(Finder finder, final org.qinshuihepan.bbs.model.BasePost.Holder target, Object source) {
    View view;
    view = finder.findById(source, 2131361816);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361816' for field 'layout' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.layout = (android.widget.LinearLayout) view;
    view = finder.findById(source, 2131361803);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361803' for field 'time' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.time = (android.widget.TextView) view;
    view = finder.findById(source, 2131361815);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361815' for field 'author' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.author = (android.widget.TextView) view;
    view = finder.findById(source, 2131361806);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361806' for field 'content' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.content = (android.widget.TextView) view;
  }

  public static void reset(org.qinshuihepan.bbs.model.BasePost.Holder target) {
    target.layout = null;
    target.time = null;
    target.author = null;
    target.content = null;
  }
}
