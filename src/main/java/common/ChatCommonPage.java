package common;

import java.util.Formatter;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.AbstractReadOnlyModel;

import com.mychat2016.HomePage;

import page.SignUpPage;

public class ChatCommonPage extends WebPage{

	private static final long serialVersionUID = 1L;

	public ChatCommonPage() {
		super();

		Link<Object> signUp = new Link<Object>("signUp"){

			@Override
			public void onClick() {
				setResponsePage(new SignUpPage());
			}

			@Override
			protected void onConfigure() {
				super.onConfigure();

				setVisible(!MySession.get().isLoggedIn());
			}
		};

		Link<Object> signIn = new Link<Object>("signIn"){

			@Override
			public void onClick() {
				setResponsePage(new HomePage());
			}

			@Override
			protected void onConfigure() {
				super.onConfigure();

				setVisible(!MySession.get().isLoggedIn());
			}
		};

		Link<Object> logout = new Link<Object>("logout"){

			@Override
			public void onClick() {
				MySession.get().setLoggedIn(false);
				MySession.get().setAccountBean(null);

				setResponsePage(new HomePage());

			}

			@Override
			protected void onConfigure() {
				super.onConfigure();

				setVisible(MySession.get().isLoggedIn());
			}
		};


		this.add(new Label("hello",new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject() {

				if(MySession.get().isLoggedIn()){
					Formatter fm = new Formatter();
					fm.format("Hello %s", MySession.get().getAccountBean().getName());
					return fm.toString();
				}else{
					return "";
				}

			}
		}));

		this.add(signIn);
		this.add(signUp);
		this.add(logout);
    }
}
