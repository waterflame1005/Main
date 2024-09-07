function sum = addmatrices(a, b)
    if length(a(:,1)) == length(b(:,1)) && length(a(1,:)) == length(b(1,:))
        sum = zeros(length(a(:,1)),length(a(1,:)));
        for i = 1:length(a(:,1))
            for j = 1:length(a(1,:))
                sum(i,j) = a(i,j)+b(i,j);
            end
        end
    else
        sum = nan;
    end




    