-- -- USER
-- INSERT INTO `user` (`id`, `name`, `create_by`, `create_on`, `create_on_time`, `update_by`, `update_on`, `update_on_time`) VALUES ('e55f81ad66c349f298e4a987b50ad0dd', 'name', 'createBy', SYSDATE(),  CURRENT_TIME(), 'updateBy', SYSDATE(), CURRENT_TIME());


-- -- PROJECT
INSERT INTO `project` (`id`, `name`, `location`, `explain`, `status`, `create_by`, `create_on`, `create_on_time`,
                       `update_by`, `update_on`, `update_on_time`)
VALUES (RANDOM_UUID(), 'name', 'location', 'exaplain', 'ONLINE', 'createBy', SYSDATE(), CURRENT_TIME(), 'updateBy',
        SYSDATE(), CURRENT_TIME());

INSERT INTO `project` (`id`, `name`, `location`, `explain`, `status`, `create_by`, `create_on`, `create_on_time`,
                       `update_by`, `update_on`, `update_on_time`)
VALUES (RANDOM_UUID(), 'name', 'location', 'exaplain', 'ONLINE', 'createBy', SYSDATE(), CURRENT_TIME(), 'updateBy',
        SYSDATE(), CURRENT_TIME());

INSERT INTO `project` (`id`, `name`, `location`, `explain`, `status`, `create_by`, `create_on`, `create_on_time`,
                       `update_by`, `update_on`, `update_on_time`)
VALUES (RANDOM_UUID(), 'name', 'location', 'exaplain', 'ONLINE', 'createBy', SYSDATE(), CURRENT_TIME(), 'updateBy',
        SYSDATE(), CURRENT_TIME());

