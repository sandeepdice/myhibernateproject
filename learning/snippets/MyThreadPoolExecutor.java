package snippets;

import java.util.concurrent.*;
import java.util.*;
 
class MyThreadPoolExecutor
{
    int poolSize = 2;
 
    int maxPoolSize = 2;
 
    long keepAliveTime = 10;
 
    ThreadPoolExecutor threadPool = null;
 
    final ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(
            5);
 
    public MyThreadPoolExecutor()
    {
        threadPool = new ThreadPoolExecutor(poolSize, maxPoolSize,
                keepAliveTime, TimeUnit.SECONDS, queue);
 
    }
 
    public void runTask(Runnable task)
    {
        // System.out.println("Task count.."+threadPool.getTaskCount() );
        // System.out.println("Queue Size before assigning the
        // task.."+queue.size() );
        threadPool.execute(task);
        // System.out.println("Queue Size after assigning the
        // task.."+queue.size() );
        // System.out.println("Pool Size after assigning the
        // task.."+threadPool.getActiveCount() );
        // System.out.println("Task count.."+threadPool.getTaskCount() );
        System.out.println("Task count.." + queue.size());
 
    }
 
    public void shutDown()
    {
        threadPool.shutdown();
    }
    
    public void awaitTermination()
    {
    	try {
			threadPool.awaitTermination(10, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    public static void main(String args[])
    {
        MyThreadPoolExecutor mtpe = new MyThreadPoolExecutor();
        // start first one
        mtpe.runTask(new Runnable()
        {
            public void run()
            {
                for (int i = 0; i < 10; i++)
                {
                    try
                    {
                        System.out.println("First Task");
                        Thread.sleep(1000);
                        System.out.println("First Task done");
                    } catch (InterruptedException ie)
                    {
                    }
                }
            }
        });
        // start second one
        /*
         * try{ Thread.sleep(500); }catch(InterruptedException
         * ie){}
         */
        mtpe.runTask(new Runnable()
        {
            public void run()
            {
                for (int i = 0; i < 10; i++)
                {
                    try
                    {
                        System.out.println("Second Task");
                        Thread.sleep(1000);
                        System.out.println("Second Task done");
                    } catch (InterruptedException ie)
                    {
                    }
                }
            }
        });
        // start third one
        /*
         * try{ Thread.sleep(500); }catch(InterruptedException
         * ie){}
         */
        mtpe.runTask(new Runnable()
        {
            public void run()
            {
                for (int i = 0; i < 10; i++)
                {
                    try
                    {
                        System.out.println("Third Task");
                        Thread.sleep(1000);
                        System.out.println("Third Task done");
                    } catch (InterruptedException ie)
                    {
                    }
                }
            }
        });
        // start fourth one
        /*
         * try{ Thread.sleep(500); }catch(InterruptedException
         * ie){}
         */
        mtpe.runTask(new Runnable()
        {
            public void run()
            {
                for (int i = 0; i < 10; i++)
                {
                    try
                    {
                        System.out.println("Fourth Task");
                        Thread.sleep(1000);
                        System.out.println("Fourth Task done");
                    } catch (InterruptedException ie)
                    {
                    }
                }
            }
        });
        // start fifth one
        /*
         * try{ Thread.sleep(500); }catch(InterruptedException
         * ie){}
         */
        mtpe.runTask(new Runnable()
        {
            public void run()
            {
                for (int i = 0; i < 10; i++)
                {
                    try
                    {
                        System.out.println("Fifth Task");
                        Thread.sleep(1000);
                        System.out.println("Fifth Task done");
                    } catch (InterruptedException ie)
                    {
                    }
                }
            }
        });
        // start Sixth one
        /*
         * try{ Thread.sleep(500); }catch(InterruptedException
         * ie){}
         */
        mtpe.runTask(new Runnable()
        {
            public void run()
            {
                for (int i = 0; i < 10; i++)
                {
                    try
                    {
                        System.out.println("Sixth Task");
                        Thread.sleep(1000);
                        System.out.println("Sixth Task done");
                    } catch (InterruptedException ie)
                    {
                    }
                }
            }
        });
        mtpe.shutDown();
        mtpe.awaitTermination();
        System.out.println("shutdown completed");
    }
 
}