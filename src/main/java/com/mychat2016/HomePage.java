package com.mychat2016;



import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

import common.ChatCommonPage;
import page.MainPage;
import service.AccountService;
import service.IAccountService;


public class HomePage extends ChatCommonPage {
	private static final long serialVersionUID = 1L;

	public HomePage() {
		super();

		final TextField<String> idText = new TextField<String>("id",new Model<String>(""));
		final PasswordTextField passwordText = new PasswordTextField("password",new Model<String>(""));

		idText.setRequired(true);
		passwordText.setRequired(true);

		Form<Void> form = new Form<Void>("form") {
			private static final long serialVersionUID = 1L;
		};

		Button submitButton = new Button("submit"){
			@Override
			public void onSubmit() {
				super.onSubmit();

				IAccountService accountService = new AccountService();

				System.out.println("id:"+idText.getModelObject());
				System.out.println("pass:"+passwordText.getModelObject());

				if(idText.getModelObject() == null
						|| passwordText.getModelObject() == null){
					System.out.println("アカウントとパスワードを入力してください");
				}else if(accountService.existsAccount(
						idText.getModelObject(),
						passwordText.getModelObject())){
					// アカウントが見つかった
					setResponsePage(new MainPage());
				}
				else{
					error("アカウントが存在しないか、パスワードが間違っています");
				}
			}

			@Override
			public void onError() {
				super.onError();

				System.out.println("error");

				System.out.println("id:"+idText.getModelObject());
				System.out.println("pass:"+passwordText.getModelObject());

			}
		};

		form.add(idText);
		form.add(passwordText);
		form.add(submitButton);
		this.add(form);
		form.add(new FeedbackPanel("feedback"));
    }
}
