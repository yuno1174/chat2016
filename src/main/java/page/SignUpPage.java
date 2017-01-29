package page;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

import com.mychat2016.HomePage;

import common.ChatCommonPage;
import service.AccountService;
import service.IAccountService;

public class SignUpPage extends ChatCommonPage {
	private static final long serialVersionUID = 1L;


	public SignUpPage() {
		super();

		final TextField<String> nameText = new TextField<String>("name",new Model<String>(""));
		final PasswordTextField passwordText = new PasswordTextField("password",new Model<String>(""));
		final PasswordTextField rePasswordText = new PasswordTextField("repassword",new Model<String>(""));

		nameText.setRequired(true);
		passwordText.setRequired(true);
		rePasswordText.setRequired(true);

		Form<Void> form = new Form<Void>("form") {
			private static final long serialVersionUID = 1L;
		};

		Button submitButton = new Button("submit"){
			@Override
			public void onSubmit() {
				super.onSubmit();

				IAccountService accountService = new AccountService();

				System.out.println("name:"+nameText.getModelObject());
				System.out.println("pass:"+passwordText.getModelObject());
				System.out.println("repass:"+rePasswordText.getModelObject());


				if(nameText.getModelObject() == null
						|| passwordText.getModelObject() == null
						|| rePasswordText.getModelObject() == null){
					System.out.println("アカウントとパスワードを入力してください");
				}else if(!passwordText.getModelObject().equals(rePasswordText.getModelObject())){
					error("パスワードとパスワード再入力の値が違います。");
				}else{

					if(!accountService.existsAccount(nameText.getModelObject())){
						accountService.insert(nameText.getModelObject(),passwordText.getModelObject(),false);
						setResponsePage(new HomePage());
					}else{
						error("アカウント名が使用されています。");
					}

				}
			}

			@Override
			public void onError() {
				super.onError();

				System.out.println("error");

				System.out.println("id:"+nameText.getModelObject());
				System.out.println("pass:"+passwordText.getModelObject());
				System.out.println("pass:"+rePasswordText.getModelObject());

			}
		};

		form.add(nameText);
		form.add(passwordText);
		form.add(rePasswordText);
		form.add(submitButton);
		this.add(form);
		form.add(new FeedbackPanel("feedback"));
    }
}