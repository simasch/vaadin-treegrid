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

@PageTitle("Split2")
@Route(value = "split2", layout = MainLayout.class)
public class Split2View extends SplitLayout {

    private final Span right;
    private final Span newRight;

    public Split2View() {
        Grid<String> grid = new Grid<>();
        addToPrimary(grid);

        right = new Span("Right");
        newRight = new Span("New Right");
        newRight.setVisible(false);
        addToSecondary(right, newRight);

        grid.addColumn(s -> s);
        grid.addComponentColumn(s -> new Button(s, event -> {
            Notification.show("Hello from " + s);
            if (s.equals("C")) {
                right.setVisible(false);
                newRight.setVisible(true);
            } else {
                right.setVisible(true);
                newRight.setVisible(false);
            }
        }));

        grid.setItems(List.of("A", "B", "C"));
    }
}
