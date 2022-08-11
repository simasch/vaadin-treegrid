package ch.martinelli.demo.vaadin.views.grid;

import ch.martinelli.demo.vaadin.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Grid")
@Route(value = "grid", layout = MainLayout.class)
public class GridView extends VerticalLayout {

    public GridView() {
        Grid<Object[]> grid = new Grid<>();
        grid.addColumn(s -> s[0]);

        Object[] objects = {"A"};
        List<Object[]> array = new ArrayList<>();
        array.add(objects);

        grid.setItems(array);

        add(grid);
    }


}
