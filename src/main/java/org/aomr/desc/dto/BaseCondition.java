package org.aomr.desc.dto;

import java.time.LocalDateTime;

public class BaseCondition {

  /*** 开始时间 */
  private LocalDateTime startTime;

  /*** 结束时间 */
  private LocalDateTime endTime;

  /*** 页码 */
  private Integer page = 1;

  /*** 每页大小 */
  private Integer size = 10;

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "BaseCondition{" +
            "startTime=" + startTime +
            ", endTime=" + endTime +
            ", page=" + page +
            ", size=" + size +
            '}';
  }
}
