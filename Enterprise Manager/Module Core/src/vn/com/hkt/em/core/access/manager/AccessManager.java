/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.core.access.manager;

import org.openide.util.Lookup;
import vn.com.hkt.em.core.access.api.IAccessData;
import vn.com.hkt.em.core.access.spi.AccessData;
import vn.com.hkt.em.core.api.IEntityManager;
import vn.com.hkt.em.core.manager.history.api.IHistoryManagerEntity;

/**
 * Thực hiện truy xuất cơ sở dữ liệu có kiểm soát việc thêm, sửa xóa các entity được khai báo cần quản lý
 * @author BinLe
 */
public class AccessManager<E> extends AccessData<E> implements IAccessData<E> {

    private IHistoryManagerEntity historyManager = Lookup.getDefault().lookup(IHistoryManagerEntity.class);

    /**
     * 
     *Thực hiện insert entity và kiểm soát entity dựa vào  history manager nếu có thể
     */
    @Override
    public boolean insert(E obj) {
        if (historyManager != null && obj instanceof IEntityManager) {
            return historyManager.managerInsert((IEntityManager) obj);
        }
        return super.insert(obj);
    }

    /**
     * 
     *Thực hiện update entity và kiểm soát entity dựa vào  history manager nếu có thể
     */
    @Override
    public boolean update(E obj) {
        if (historyManager != null && obj instanceof IEntityManager) {
            return historyManager.managerUpdate((IEntityManager) obj);
        }
        return super.update(obj);
    }

    /**
     * 
     *Thực hiện delete entity và kiểm soát entity dựa vào  history manager nếu có thể
     */
    @Override
    public boolean delete(E obj) {
        if (historyManager != null && obj instanceof IEntityManager) {
            return historyManager.mangerDelete((IEntityManager) obj);
        }
        return super.delete(obj);
    }

    /**
     * 
     *Thực hiện delete entity và kiểm soát entity dựa vào  history manager nếu có thể
     */
    @Override
    public boolean deleteById(long id) {
        E obj = getById(id);
        if (historyManager != null && obj instanceof IEntityManager) {
            return historyManager.mangerDelete((IEntityManager) obj);
        }
        return super.deleteById(id);
    }
}
