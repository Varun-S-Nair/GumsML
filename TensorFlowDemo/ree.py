import numpy as np

# data points
X = np.array([[1., 2.], [3., -3.], [-2., 2.], [2., 5.], [4., -1.]])
y_true = np.array([-1.4, 24.2, -16.2, -5.1, 22.9])
n_points = X.shape[0]

# set update rate
alpha = 0.1

# initialize our guess for w
w = np.array([3., -5.])

# iterate over the data set 20 times
for iter in range(20):

    # iterate over each data point
    for p in range(n_points):
        x = X[p]
        yn = y_true[p]

        # forward pass
        y = x[0] * w[0] + x[1] * w[1]  # student code goes here

        # backward pass
        dSdy = (y - yn) / n_points  # student code hoes here
        dydw = np.array([x[0], x[1]])  # student code goes here
        dSdw = dSdy * dydw

        # update w
        w = w - alpha * dSdw
        print("y = " + str(y))
        print("dSdy = " + str(dSdy))
        print("dydw = " + str(dydw))
        print("dSdw = " + str(dSdw))
        print("w = " + str(w))
