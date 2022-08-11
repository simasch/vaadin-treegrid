package ch.martinelli.demo.vaadin.views.split;

import ch.martinelli.demo.vaadin.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@PageTitle("Split")
@Route(value = "split", layout = MainLayout.class)
public class SplitView extends SplitLayout {

    public SplitView() {
        Grid<String> grid = new Grid<>();

        grid.addColumn(s -> s);
        grid.addComponentColumn(s -> new Button(s, event -> {
            Notification.show("Hello from " + s);
            if (s.equals("C")) {
                remove(getSecondaryComponent());
                addToSecondary(new Span("New Right"));
            }
        }));

        grid.setItems(List.of("A", "B", "C"));

        addToPrimary(grid);
        addToSecondary(new Span("Right"));
    }
}
