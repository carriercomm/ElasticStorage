load bwController.dump;
load bwWithoutController.dump;
m1 = size(bwController, 1);
m2 = size(bwWithoutController, 1);
xMin = min(m1, m2);
sampling = 25;

X = [0: sampling: sampling*(xMin-1)];
p1 = plot(X, bwController(1:xMin, 1), '-mo');
set(p1,'Color','red','LineWidth',1);
hold all;
p2 = plot(X, bwWithoutController(1:xMin, 1), '-.r*');
set(p2,'Color','blue','LineWidth',1);
set(gca, ...
  'XMinorTick'  , 'on'      , ...
  'YMinorTick'  , 'on'      , ...
  'YGrid'       , 'on'      , ...
  'XGrid'       , 'on'      , ...
  'XColor'      , [.3 .3 .3], ...
  'YColor'      , [.3 .3 .3], ...
  'LineWidth'   , 1         );
hTitle = title('Average Bandwidth per download');
hXLabel = xlabel('Time (s)');
hYLabel = ylabel('Average Bandwidth (B/s)');
legend('w/ controller', 'w/o controller');
set([hXLabel, hYLabel]  , ...
    'FontSize'   , 10          );
set( hTitle                    , ...
    'FontSize'   , 12          , ...
    'FontWeight' , 'bold'      );