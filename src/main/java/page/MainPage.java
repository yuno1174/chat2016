package page;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;

import com.google.inject.Inject;

import bean.MessageBean;
import common.ChatCommonPage;
import service.IMessageService;
import service.MessageService;

public class MainPage extends ChatCommonPage {
	private static final long serialVersionUID = 1L;

	@Inject
	IMessageService messageService;

	public MainPage() {
		super();


		final IModel<List<MessageBean>> messageListModel = new ListModel<MessageBean>(){;
			@Override
			public List<MessageBean> getObject() {
				return new MessageService().select();
			}
		};


		final WebMarkupContainer messageComponent = new WebMarkupContainer("messageComponent"){
			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupId(true);
			}
		};

		ListView<MessageBean> messageListView = new ListView<MessageBean>("messageList", messageListModel) {

			@Override
			protected void populateItem(ListItem<MessageBean> item) {
				item.add(new Label("message", item.getModelObject().getMessage()));
				item.add(new Label("accountName", item.getModelObject().getAccountBean().getName()));
				item.add(new Label("postTime", item.getModelObject().getPostTime()));
			}
		};

		AjaxLink<Void> messageReloadLink = new AjaxLink<Void>("messageReloadLink"){

			@Override
			public void onClick(AjaxRequestTarget target) {
				messageListModel.getObject().remove(2);

				target.add(messageComponent);
			}
		};

		messageComponent.add(messageReloadLink);
		messageComponent.add(messageListView);

		this.add(messageComponent);

    }
}