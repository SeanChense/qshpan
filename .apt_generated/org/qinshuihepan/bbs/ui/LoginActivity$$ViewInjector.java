// Generated code from Butter Knife. Do not modify!
package org.qinshuihepan.bbs.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class LoginActivity$$ViewInjector {
  public static void inject(Finder finder, final org.qinshuihepan.bbs.ui.LoginActivity target, Object source) {
    View view;
    view = finder.findById(source, 2131361812);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361812' for field 'usernameText' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.usernameText = (android.widget.EditText) view;
    view = finder.findById(source, 2131361814);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361814' for field 'confirm' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.confirm = (android.widget.Button) view;
    view = finder.findById(source, 2131361813);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131361813' for field 'passwordText' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.passwordText = (android.widget.EditText) view;
  }

  public static void reset(org.qinshuihepan.bbs.ui.LoginActivity target) {
    target.usernameText = null;
    target.confirm = null;
    target.passwordText = null;
  }
}
