package org.aomr.desc.util.tree;

import java.util.List;

public interface TreeEntity<E> {

    Integer getId();

    Integer getPid();

    void setChildList(List<E> childList);

}
