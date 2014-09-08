// Generated code from Butter Knife. Do not modify!
package org.qinshuihepan.bbs.ui.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DrawerAdapter$Holder$$ViewInjector {
  public static void inject(Finder finder, final org.qinshuihepan.bbs.ui.adapter.DrawerAdapter.Holder target, Object source) {
    View view;
    view = finder.findById(source, 2131361799);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361799' for field 'category' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.category = (android.widget.TextView) view;
  }

  public static void reset(org.qinshuihepan.bbs.ui.adapter.DrawerAdapter.Holder target) {
    target.category = null;
  }
}
