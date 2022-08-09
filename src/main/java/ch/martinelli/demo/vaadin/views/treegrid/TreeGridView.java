package ch.martinelli.demo.vaadin.views.treegrid;

import ch.martinelli.demo.vaadin.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.util.ArrayList;
import java.util.List;

@PageTitle("TreeGrid")
@Route(value = "treegrid", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class TreeGridView extends VerticalLayout {


    public TreeGridView() {
        TreeGrid<Node> treeGrid = new TreeGrid<>();
        treeGrid.addHierarchyColumn(Node::getName).setHeader("Name");

        List<Node> nodes = createData();

        treeGrid.setItems(nodes, Node::getChildren);

        add(treeGrid);
    }

    private List<Node> createData() {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Node node = new Node();
            node.setName("Name " + i);
            nodes.add(node);

            for (int j = 0; j < 5; j++) {
                Node child = new Node();
                child.setName("Name " + i + " " + j);
                node.getChildren().add(child);
            }
        }
        return nodes;
    }

}
