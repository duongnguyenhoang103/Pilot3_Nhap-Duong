/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.core.manager.history.api;

import vn.com.hkt.em.core.api.IEntity;

/**
 * Mặt nạ quản lý lịch sử cơ sở dữ liệu
 * @author BinLe
 */
public interface IHistoryManagerEntity {

    /**
     * Quản lý việc thêm dữ liệu
     * True: nếu quản lý việc insert thành công 
     * False: ngược lại
     */
    public boolean managerInsert(IEntity obj);

    /**
     * Quản lý việc sửa dữ liệu
     * * True: nếu quản lý việc update thành công 
     * False: ngược lại
     */
    public boolean managerUpdate(IEntity obj);

    /**
     * Quản lý việc xóa dữ liệu
     * * True: nếu quản lý việc deltete thành công 
     * False: ngược lại
     */
    public boolean mangerDelete(IEntity obj);
}
