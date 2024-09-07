function product = multiplymatrices(a, b)
    if length(a(1,:)) == length(b(:,1))
        count = length(a(1,:));
        product = zeros(length(a(:,1)),length(b(1,:)));
        for i = 1:length(b(1,:))
            for j = 1:length(a(:,1))
                for k = 1:count
                    product(j,i) = product(j,i) + a(j,k) * b(k,i);
                end
            end
        end
    else
        product = nan;
    end