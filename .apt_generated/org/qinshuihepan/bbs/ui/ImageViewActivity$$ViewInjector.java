// Generated code from Butter Knife. Do not modify!
package org.qinshuihepan.bbs.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ImageViewActivity$$ViewInjector {
  public static void inject(Finder finder, final org.qinshuihepan.bbs.ui.ImageViewActivity target, Object source) {
    View view;
    view = finder.findById(source, 2131361793);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361793' for field 'progressWheel' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.progressWheel = (org.qinshuihepan.bbs.view.ProgressWheel) view;
    view = finder.findById(source, 2131361792);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361792' for field 'photoView' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.photoView = (uk.co.senab.photoview.PhotoView) view;
  }

  public static void reset(org.qinshuihepan.bbs.ui.ImageViewActivity target) {
    target.progressWheel = null;
    target.photoView = null;
  }
}
