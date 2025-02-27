select i.ID as ID, n.FISH_NAME as FISH_NAME, i.LENGTH as LENGTH 
    from FISH_INFO i join FISH_NAME_INFO n 
    on i.FISH_TYPE = n.FISH_TYPE
    where i.length = (
            select MAX(i2.length)
            from FISH_INFO i2
            where i2.FISH_TYPE = i.FISH_TYPE)
    ORDER BY i.ID;
