package ch.martinelli.demo.vaadin.views.refresh;

import ch.martinelli.demo.vaadin.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.CallbackDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Refresh")
@Route(value = "refresh", layout = MainLayout.class)
public class RefreshView extends VerticalLayout {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefreshView.class);

    private final List<String> data = new ArrayList<>();
    private final CallbackDataProvider<String, Void> dataProvider;

    public RefreshView() {
        Grid<String> grid = new Grid<>();
        grid.addColumn(s -> s);

        dataProvider = new CallbackDataProvider<>(
                query -> {
                    LOGGER.info("fetch");
                    return data.stream().skip(query.getOffset()).limit(query.getLimit());
                },
                query -> {
                    LOGGER.info("count");
                    return data.size();
                },
                s -> s);

        grid.setItems(dataProvider);

        Button addData = new Button("Add data", event -> {
            data.add(System.currentTimeMillis() + " ms");
            dataProvider.refreshAll();
        });

        Button refresh = new Button("Refresh", event -> dataProvider.refreshAll());

        add(grid, addData, refresh);
    }
}
