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

    private final Span right;
    private final Span newRight;

    public SplitView() {
        Grid<String> grid = new Grid<>();
        addToPrimary(grid);

        right = new Span("Right");
        addToSecondary(right);
        newRight = new Span("New Right");

        grid.addColumn(s -> s);
        grid.addComponentColumn(s -> new Button(s, event -> {
            Notification.show("Hello from " + s);
            if (s.equals("C")) {
                if (getSecondaryComponent().equals(right)) {
                    addToSecondary(newRight);
                }
            } else {
                if (getSecondaryComponent().equals(newRight)) {
                    addToSecondary(right);
                }
            }
        }));

        grid.setItems(List.of("A", "B", "C"));

    }
}
