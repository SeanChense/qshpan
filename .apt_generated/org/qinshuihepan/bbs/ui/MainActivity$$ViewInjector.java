// Generated code from Butter Knife. Do not modify!
package org.qinshuihepan.bbs.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final org.qinshuihepan.bbs.ui.MainActivity target, Object source) {
    View view;
    view = finder.findById(source, 2131361794);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361794' for field 'mDrawerLayout' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.mDrawerLayout = (org.qinshuihepan.bbs.view.FoldingDrawerLayout) view;
  }

  public static void reset(org.qinshuihepan.bbs.ui.MainActivity target) {
    target.mDrawerLayout = null;
  }
}
